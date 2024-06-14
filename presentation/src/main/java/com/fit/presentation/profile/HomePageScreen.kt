package com.fit.presentation.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fit.data.model.LoginRequest
import com.fit.resources.R
import com.fit.resources.theme.Additionally
import com.fit.resources.theme.ChooseAtarif
import com.fit.resources.theme.DisabledButtonColor
import com.fit.resources.theme.Favorite
import com.fit.resources.theme.HomeLight
import com.fit.resources.theme.IvanovIvan
import com.fit.resources.theme.LightOne
import com.fit.resources.theme.PaymentHistory
import com.fit.resources.theme.QrCode
import com.fit.resources.theme.SupportServic
import com.fit.resources.theme.YourTariff

@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {

    HomePageScreen(login = {})

}

@Composable
fun HomePageScreen(
    login: (LoginRequest) -> Unit = { LoginRequest() },
    navigateToVerify: () -> Unit = {}
) {

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = IvanovIvan,
                fontSize = 25.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f)
            )

            Spacer(modifier = Modifier.width(5.dp))

            Box(
                modifier = Modifier
                    .size(24.dp)
                    .background(DisabledButtonColor),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_home_page),
                    contentDescription = null,
                    modifier = Modifier.size(16.dp)
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .clip(shape = RoundedCornerShape(size = 8.dp))
                    .background(DisabledButtonColor)
                    .padding(10.dp),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = QrCode,
                        color = Color.Black,
                        fontSize = 19.sp,
                        fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.Left,
                        modifier = Modifier.weight(1f)
                    )

                    Image(
                        painter = painterResource(R.drawable.img_qr),
                        contentDescription = null,
                        modifier = Modifier.size(40.dp)
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .clip(shape = RoundedCornerShape(size = 8.dp))
                    .background(Color.White)
                    .padding(10.dp),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = YourTariff,
                        color = Color.Black,
                        fontSize = 19.sp,
                        fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.Left,
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
                    )

                    Box(
                        modifier = Modifier
                            .size(width = 120.dp, height = 120.dp)
                            .background(HomeLight, shape = RoundedCornerShape(8.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(4.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = LightOne,
                                color = Color.White,
                                fontSize = 19.sp,
                                fontWeight = FontWeight.ExtraBold
                            )

                            Text(
                                text = "1 700", color = Color.White,
                                fontSize = 25.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                            Text(
                                text = "р/мес", color = Color.White,
                                fontSize = 19.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }

                }

            }

        }
        Spacer(modifier = Modifier.height(20.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .width(309.dp)
                    .height(206.dp) // Увеличил высоту для примера
                    .clip(shape = RoundedCornerShape(size = 8.dp))
                    .background(DisabledButtonColor)
                    .padding(10.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Top
                ) {
                    ImageTextImageBlock(R.drawable.img_payment_history, PaymentHistory, R.drawable.img_right)
                    Spacer(modifier = Modifier.weight(1f))
                    ImageTextImageBlock(R.drawable.img_favorite, Favorite, R.drawable.img_right)
                    Spacer(modifier = Modifier.weight(1f))
                    ImageTextImageBlock(R.drawable.img_choose_a_tariff, ChooseAtarif, R.drawable.img_right)
                    Spacer(modifier = Modifier.weight(1f))
                    ImageTextImageBlock(R.drawable.img_additionally, Additionally, R.drawable.img_right)
                    Spacer(modifier = Modifier.weight(1f))
                    ImageTextImageBlock(R.drawable.img_support_service, SupportServic, R.drawable.img_right)
                }

            }
        }
        Spacer(modifier = Modifier.height(250.dp))
        Row(
            modifier = Modifier.fillMaxWidth(), // Растягиваем Row на всю ширину
            horizontalArrangement = Arrangement.SpaceEvenly, // Устанавливаем равное расстояние между элементами
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.img_additionally),
                contentDescription = "Image 1",
                modifier = Modifier.size(30.dp) // Устанавливаем размер изображения
            )
            Image(
                painter = painterResource(id = R.drawable.img_additionally),
                contentDescription = "Image 2",
                modifier = Modifier.size(30.dp) // Устанавливаем размер изображения
            )
            Image(
                painter = painterResource(id = R.drawable.img_additionally),
                contentDescription = "Image 1",
                modifier = Modifier.size(30.dp) // Устанавливаем размер изображения
            )
            Image(
                painter = painterResource(id = R.drawable.img_additionally),
                contentDescription = "Image 2",
                modifier = Modifier.size(30.dp) // Устанавливаем размер изображения
            )
            Button(onClick = { /* Действие при нажатии на кнопку */ }) {
                Text("Кнопка")
            }
        }



        Spacer(modifier = Modifier.height(25.dp))

    }
}


@Composable
fun ImageTextImageBlock(leftImageResId: Int, text: String, rightImageResId: Int) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = leftImageResId),
            contentDescription = "Left Image"
        )
        Box(
            modifier = Modifier
                .weight(1f)
                .padding(start = 10.dp)
        ) {
            Text(
                text = text,
                color = Color.Black,
                fontSize = 19.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Start
            )
        }
        Image(
            painter = painterResource(id = rightImageResId),
            contentDescription = "Right Image"
        )
    }
}















