package com.example.myapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension


class Ejercicio2 {

    @Composable
    fun Layout() {
        var azul by remember { mutableStateOf(true) }
        var verde by remember { mutableStateOf(true) }
        var rojo by remember { mutableStateOf(true) }

        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Referencias del ConstraintLayout
            val (cbAzul, cbVerde, cbRojo, boxAzul, boxVerde, boxRojo) = createRefs()

            // Cuadro azul (abajo a la izquierda)
            if (azul) {
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .background(Color.Blue)
                        .constrainAs(boxAzul) {
                            start.linkTo(parent.start)
                            bottom.linkTo(boxVerde.top, margin = 40.dp)
                        }
                )
            }

            // Cuadro verde (abajo al centro)
            if (verde) {
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .background(Color.Green)
                        .constrainAs(boxVerde) {
                            start.linkTo(boxAzul.end, margin = 40.dp)
                            bottom.linkTo(parent.bottom, margin = 80.dp)
                        }
                )
            }

            // Cuadro rojo (arriba a la derecha)
            if (rojo) {
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .background(Color.Red)
                        .constrainAs(boxRojo) {
                            top.linkTo(parent.top, margin = 100.dp)
                            end.linkTo(parent.end, margin = 60.dp)
                        }
                )
            }

            // Checkbox Azul
            Row(
                modifier = Modifier.constrainAs(cbAzul) {
                    top.linkTo(parent.top, margin = 100.dp)
                    start.linkTo(parent.start)
                },
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Checkbox(checked = azul, onCheckedChange = { azul = it })
                Text("Azul")
            }

            // Checkbox Verde
            Row(
                modifier = Modifier.constrainAs(cbVerde) {
                    top.linkTo(cbAzul.bottom, margin = 120.dp)
                    start.linkTo(parent.start, margin = 80.dp)
                },
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Checkbox(checked = verde, onCheckedChange = { verde = it })
                Text("Verde")
            }

            // Checkbox Rojo
            Row(
                modifier = Modifier.constrainAs(cbRojo) {
                    top.linkTo(cbVerde.top)
                    start.linkTo(cbVerde.end, margin = 80.dp)
                },
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Checkbox(checked = rojo, onCheckedChange = { rojo = it })
                Text("Rojo")
            }
        }
    }


    @Preview(showBackground = true)
    @Composable
    fun PreviewLayout() {
        Layout()
    }
}
