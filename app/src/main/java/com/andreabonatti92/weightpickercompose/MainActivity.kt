package com.andreabonatti92.weightpickercompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var weight by remember {
                mutableStateOf(80)
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(600.dp)
                        .align(Alignment.Center),
                    text = "Select your weight",
                    color = Color.Black,
                    fontSize = 35.sp,
                    textAlign = TextAlign.Center
                )

                Text(
                    modifier = Modifier
                        .width(180.dp)
                        .height(200.dp)
                        .align(Alignment.Center),
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = Color.Black,
                                fontSize = 70.sp
                            )
                        ) {
                            append(weight.toString())
                        }
                        append(" KG")
                    },
                    color = Color.Green,
                    fontSize = 35.sp,
                    textAlign = TextAlign.End
                )

                Scale(
                    style = ScaleStyle(
                        scaleWidth = 150.dp
                    ),
                    modifier = Modifier
                        //  .fillMaxWidth() not work because pointerInput to capture the touch event need a fixed Height
//                        .fillMaxSize()
                        .fillMaxWidth()
                        .height(400.dp)
//                        .align(Alignment.Center)
                        .align(Alignment.BottomCenter)
                ) {
                    weight = it
                }
            }
        }
    }
}

