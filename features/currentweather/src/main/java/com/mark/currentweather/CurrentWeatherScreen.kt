package com.mark.currentweather

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import com.mark.uikit.colors.PurpleDark
import com.mark.uikit.colors.PurpleLight
import androidx.hilt.navigation.compose.hiltViewModel
import com.mark.core.navigation.Screen
import com.mark.core.navigation.Screen.CurrentWeather
import com.mark.core.navigation.withCity

@Composable
fun CurrentWeatherScreen(navController: NavController?, city: String) {
    val viewModel: CurrentWeatherViewModel = hiltViewModel()
    val weatherState by viewModel.weatherState.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()


    LaunchedEffect(key1 = city) {
        viewModel.fetchWeatherData(city)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        PurpleDark,
                        PurpleLight
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (!isLoading)
                WeatherHeader(weatherState)
            else {
                LoadingIndicator()
            }
            Spacer(modifier = Modifier.height(16.dp))

            HouseIllustration()

            Spacer(modifier = Modifier.height(16.dp))

            ForecastDetails(navController, city)

            Spacer(modifier = Modifier.height(16.dp))
        }


    }
}

@Composable
fun LoadingIndicator() {
    Box(
        modifier = Modifier.fillMaxSize() // Parent Box
    ) {
        CircularProgressIndicator(
            modifier = Modifier.align(Alignment.Center), // Align to the center of the Box
            color = Color.White
        )
    }
}

@Composable
fun WeatherHeader(weatherState: CurrentWeatherState?) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = com.mark.core.R.drawable.applogo), // Replace with your drawable
            contentDescription = "Weather Icon",
            modifier = Modifier.size(100.dp),
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = weatherState?.temperature.toString(),
            style = TextStyle(
                color = Color.White,
                fontSize = 64.sp,
                fontWeight = FontWeight.Bold
            )
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Precipitations\nMax: ${weatherState?.maxTemp}°  Min: ${weatherState?.minTemp}°",
            style = TextStyle(
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            ),
            lineHeight = 20.sp
        )
    }
}

@Composable
fun HouseIllustration() {
    Image(
        painter = painterResource(id = com.mark.core.R.drawable.houseicon), // Replace with your drawable
        contentDescription = "House Illustration",
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp),
        contentScale = ContentScale.Fit
    )
}

@Composable
fun ForecastDetails(navController: NavController?, city: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        val context = LocalContext.current

        // First button (Change City) - Centered
        Button(
            onClick = {
                navController?.navigateUp()
            },
            modifier = Modifier
                .height(50.dp),
            shape = RoundedCornerShape(25.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow),
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_edit_location_24),
                contentDescription = "Location Icon",
                tint = PurpleDark
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Change City",
                style = TextStyle(
                    color = PurpleDark,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }

        OutlinedButton(
            onClick = {
                navController?.navigate(Screen.ForcastWeather.withCity(city = city))

            },
            modifier = Modifier
                .height(50.dp),
            shape = RoundedCornerShape(25.dp),
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = Color.White
            ),
            border = androidx.compose.foundation.BorderStroke(
                width = 2.dp,
                color = Color.White
            )
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_launcher_foreground), // Replace with a forecast icon
                contentDescription = "Forecast Icon",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Go to Forecast",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val navigationController: NavController? = null
    CurrentWeatherScreen(navigationController, city = "cairo")
}