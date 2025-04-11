package com.mark.homefeature

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.mark.homefeature.ui.theme.MyWeatherAPPTaskTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mark.core.navigation.Screen.CurrentWeather
import com.mark.core.navigation.withCity
import com.mark.uikit.colors.LightGray
import com.mark.uikit.colors.PurpleDark
import com.mark.uikit.colors.PurpleLight
import com.mark.uikit.colors.White
import com.mark.uikit.colors.Yellow

@Composable
fun HomeScreen(navController: NavController?) {
    var cityName by remember { mutableStateOf("") }
    val viewModel: HomeViewModel = hiltViewModel()

    val state = viewModel.uiState

    Box(
        modifier = Modifier
            .fillMaxSize()
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
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Image(
                painter = painterResource(id = R.mipmap.ic_launcher_foreground), // Replace with your drawable resource
                contentDescription = "Weather Icon",
                modifier = Modifier
                    .size(250.dp),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Weather",
                style = TextStyle(
                    color = White,
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold
                )
            )

            Text(
                text = "ForeCasts",
                style = TextStyle(
                    color = Yellow,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Medium
                )
            )


            Spacer(modifier = Modifier.height(32.dp))

            OutlinedTextField(
                value = cityName,
                onValueChange = {
                    cityName = it
                    viewModel.onCityNameChange(it)
                },
                label = {
                    Text(
                        text = "Enter City Name",
                        color = White
                    )
                },
                placeholder = {
                    Text(
                        text = "City Name",
                        color = LightGray
                    )
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = Yellow,
                    unfocusedIndicatorColor = Color.White,
                    cursorColor = Yellow,
                    focusedLabelColor = Yellow,
                    unfocusedLabelColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(48.dp))
            val context = LocalContext.current
            Button(
                onClick = {
                    if (!cityName.isNullOrEmpty()) {
                        viewModel.onSubmitCity()
                        navController?.navigate(CurrentWeather.withCity(cityName))
                    } else {
                        Toast.makeText(context, "Enter City Name", Toast.LENGTH_SHORT).show()
                    }
                },
                modifier = Modifier
                    .width(200.dp)
                    .height(50.dp),
                shape = RoundedCornerShape(25.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow)
            ) {
                Text(
                    text = "Get Start",
                    style = TextStyle(
                        color = PurpleDark,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyWeatherAPPTaskTheme {
        val navigationController: NavController? = null
        HomeScreen(navigationController)

    }
}