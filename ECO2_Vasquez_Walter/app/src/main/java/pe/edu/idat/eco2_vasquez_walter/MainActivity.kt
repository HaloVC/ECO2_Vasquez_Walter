package pe.edu.idat.eco2_vasquez_walter

import MenuScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "menu") {
                composable("menu") { MenuScreen(navController) }

                composable("formulario") {
                   // Formulario()
                }
                composable("listas") {
                   // listas()
                }

            }
        }
    }
}

@Composable
fun MySpace(espacio: Int){
    Spacer(modifier = Modifier.size(espacio.dp))
}