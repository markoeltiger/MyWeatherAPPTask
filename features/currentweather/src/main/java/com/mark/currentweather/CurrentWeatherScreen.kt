package com.mark.currentweather

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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import com.mark.uikit.colors.PurpleDark
import com.mark.uikit.colors.PurpleLight
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun CurrentWeatherScreen(navController: NavController?) {
    val viewModel: CurrentWeatherViewModel = hiltViewModel()
    val weatherState by viewModel.weatherState.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
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

            ForecastDetails(navController)

            Spacer(modifier = Modifier.height(16.dp))
        }

        // Bottom Navigation Bar
        BottomNavigationBar(modifier = Modifier.align(Alignment.BottomCenter))
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
        // Weather Icon
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
fun ForecastDetails(navController: NavController?) {
    Row(
        modifier = Modifier
            .fillMaxWidth()

            .padding(16.dp)
    ) {


        // Hourly Forecast
        IconButton(onClick = { navController?.navigateUp() }) {

            Icon(
                painter = painterResource(id = R.drawable.ic_launcher_foreground), // Replace with your drawable
                contentDescription = "Location Icon",
                tint = Color.White
            )

        }
        Text(text = "Change City")
    }
}


@Composable
fun BottomNavigationBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = Color(0xFF5E17EB), // Purple background
                shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
            )
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        IconButton(onClick = { /* Handle add click */ }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_launcher_foreground), // Replace with your drawable
                contentDescription = "Add Icon",
                tint = Color.White
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

    val navigationController: NavController? = null
    CurrentWeatherScreen(navigationController)


}