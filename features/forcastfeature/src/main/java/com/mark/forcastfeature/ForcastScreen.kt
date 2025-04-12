import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mark.forcastfeature.ForecastViewModel
import com.mark.forcastfeature.R
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.layout.ContentScale
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.mark.domain.forcastDomain.response.Forecastday
import com.mark.forcastfeature.ForecastIntent
import com.mark.uikit.toDayName
import java.util.List

@Composable
fun WeatherScreen(navController: NavController?, city: String) {
    val viewModel: ForecastViewModel = hiltViewModel()
    val state by viewModel.state.collectAsState()

    LaunchedEffect(key1 = city) {
        viewModel.processIntent(ForecastIntent.LoadForecast(city))
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF1A2151),
                        Color(0xFF5B3A8E),
                        Color(0xFF8E459A)
                    )
                )
            )
    ) {
        if (!state.isLoading){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(48.dp))

            Text(
                text = "${city}",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Row(
                modifier = Modifier.padding(top = 4.dp)
            ) {
                Text(
                    text = "Max: ${state.maxTemp}°",
                    color = Color.White,
                    fontSize = 18.sp
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = "Min:${state.minTemp}°",
                    color = Color.White,
                    fontSize = 18.sp
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "7-Days Forecasts",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.Start)
            )

            Spacer(modifier = Modifier.height(16.dp))

            ForecastLazyRow(state.days)

            Spacer(modifier = Modifier.height(24.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0x33FFFFFF)
                )
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_ac_unit_24),
                            contentDescription = "Air Quality",
                            tint = Color.White,
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Condition",
                            color = Color.White,
                            fontSize = 14.sp
                        )
                    }

                    Text(
                        text = state.condition.toString(),
                        color = Color.White,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )

                    Divider(
                        color = Color.White.copy(alpha = 0.3f),
                        thickness = 1.dp,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )

                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Card(
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0x33FFFFFF)
                    )
                ) {
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.Start
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_ac_unit_24),
                                contentDescription = "Sunrise",
                                tint = Color.White,
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "Humadity",
                                color = Color.White,
                                fontSize = 14.sp
                            )
                        }

                        Text(
                            text = state.humadity,
                            color = Color.White,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(vertical = 8.dp)
                        )

                        Text(
                            text = "Sunset: 7.25PM",
                            color = Color.White,
                            fontSize = 14.sp
                        )
                    }
                }

                Spacer(modifier = Modifier.width(16.dp))

                // UV Index card
                Card(
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0x33FFFFFF)
                    )
                ) {
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.Start
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_ac_unit_24),
                                contentDescription = "UV Index",
                                tint = Color.White,
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "UV INDEX",
                                color = Color.White,
                                fontSize = 14.sp
                            )
                        }

                        Text(
                            text = state.uvIndex,
                            color = Color.White,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(top = 8.dp)
                        )

                        Text(
                            text = "Moderate",
                            color = Color.White,
                            fontSize = 16.sp
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            // Navigation dots
            Row(
                modifier = Modifier.padding(bottom = 16.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                repeat(3) { index ->
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 4.dp)
                            .size(width = 24.dp, height = 3.dp)
                            .background(
                                color = if (index == 0) Color.White else Color.White.copy(alpha = 0.5f),
                                shape = RoundedCornerShape(2.dp)
                            )
                    )
                }
            }
        }
        }
        else{
            LoadingIndicator()
        }
    }
}
@Composable
fun LoadingIndicator() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        CircularProgressIndicator(
            modifier = Modifier.align(Alignment.Center),
            color = Color.White
        )
    }
}
@Composable
fun ForecastLazyRow(days: List<Forecastday>?) {
    val forecastData = days?.mapIndexed { index, forecast ->
        ForecastDay(
            day = forecast.dateEpoch.toDayName().orEmpty(),
            temperature = "${forecast.day.avgtempC ?: "--"}°C",
            iconResId = R.drawable.baseline_ac_unit_24,
            icon=forecast.day.condition.icon,
            color = when (index % 3) {
                0 -> Color(0xFF7953A9)
                1 -> Color(0xFF645B9A)
                else -> Color(0xFF8E459A)
            }
        )
    } ?: emptyList()

    LazyRow(
        contentPadding = PaddingValues(horizontal = 4.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(forecastData) { day ->
            DayForecast(
                temperature = day.temperature,
                day = day.day,
                iconResId = day.iconResId,
                icon = day.icon,
                color = day.color
            )
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun DayForecast(
    temperature: String,
    day: String,
    iconResId: Int,
    icon: String,
    color: Color
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clip(RoundedCornerShape(32.dp))
            .background(color)
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        Text(
            text = temperature,
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))


        val icon = "https:${icon}"
        GlideImage(
            model = icon,
            contentDescription = "Weather Icon",
            modifier = Modifier.size(50.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = day,
            color = Color.White,
            fontSize = 16.sp
        )
    }
}

 data class ForecastDay(
    val day: String,
    val temperature: String,
    val iconResId: Int,
    val icon: String,
    val color: Color
)

@Preview(showBackground = true)
@Composable
fun WeatherScreenPreview() {
    WeatherScreen(null,"")
}