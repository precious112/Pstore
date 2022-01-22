package com.precious.pstore

import android.os.Bundle
import android.view.animation.OvershootInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.precious.pstore.ui.theme.PstoreTheme
import kotlinx.coroutines.delay
import org.intellij.lang.annotations.JdkConstants

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PstoreTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize()) {
                    Navigation()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun Navigation(){
    val navcontroller= rememberNavController()
    NavHost(navController = navcontroller, startDestination = "splash_screen"){
        composable("splash_screen"){
           SplashScreen(navController = navcontroller)
        }
        composable("main_screen"){
            HomeScreen()
        }
    }
}

@Composable
fun SplashScreen(navController: NavController){
    val scale = remember{
        androidx.compose.animation.core.Animatable(0f)
    }
    LaunchedEffect(key1 = true ){
        scale.animateTo(
            targetValue = 0.8f,
            animationSpec = tween(
                durationMillis = 500,
                easing = {
                    OvershootInterpolator(2f).getInterpolation(it)
                }
            )
        )
        delay(3000L)
        navController.navigate("main_screen")

    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFc56200))
    ) {
       Column(horizontalAlignment = Alignment.CenterHorizontally,
           modifier=Modifier.fillMaxWidth()){
           Image(painter = painterResource(id = R.drawable.ic_refundpana), contentDescription = "logo",
               modifier = Modifier.scale(scale.value)
           )
           Text(text = "Pstore",color = Color(0xFFdaebdf),fontSize = 25.sp)
       }

    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PstoreTheme {
        Greeting("Android")
    }
}