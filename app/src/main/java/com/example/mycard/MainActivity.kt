package com.example.mycard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycard.ui.theme.MyCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Mycard()
                }
            }
        }
    }
}

@Composable
fun Mycard() {
    MyCardTotal(
        image = painterResource(id = R.drawable.bilibili),
        name = stringResource(id = R.string.full_name),
        title = stringResource(id = R.string.title),
        tel = stringResource(id = R.string.tel),
        mail = stringResource(id = R.string.mail),
        address = stringResource(id = R.string.address)
    )
}

@Composable
private fun MyCardTotal(
    image: Painter, name: String, title: String, tel: String,
    mail: String,
    address: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        MyCardTop(image = image, name = name, title = title, modifier=Modifier.weight(4f))
        MyCardBotton(tel = tel, mail = mail, address = address, modifier=Modifier.weight(3f))
    }
}

@Composable
private fun MyCardTop(image: Painter, name: String, title: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(painter = image, contentDescription = null)
        Text(text = name, fontSize = 48.sp)
        Text(text = title, fontSize = 24.sp)
    }
}

@Composable
private fun MyCardBotton(
    tel: String,
    mail: String,
    address: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = tel, fontSize = 24.sp , modifier = Modifier.padding(16.dp))
        Text(text = mail, fontSize = 20.sp, modifier = Modifier.padding(16.dp))
        Text(text = address, fontSize = 24.sp, modifier = Modifier.padding(16.dp))

    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyCardTheme {
        Mycard()
    }
}