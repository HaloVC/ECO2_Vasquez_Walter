package pe.edu.idat.eco2_vasquez_walter

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class TestPsicologico(val titulo: String, val descripcion: String, val fechaPublicacion: String)

@Composable
fun listas() {
    var mostrarLista by remember { mutableStateOf(false) }
    val listaDeTests = listOf(
        TestPsicologico("Test de Personalidad", "Evalúa diferentes aspectos de la personalidad.", "01-01-2021"),
        TestPsicologico("Test de Ansiedad", "Mide el nivel de ansiedad de una persona.", "05-02-2021"),
        TestPsicologico("Test de Depresión", "Ayuda a identificar signos de depresión.", "12-03-2021"),
        TestPsicologico("Test de Inteligencia Emocional", "Determina la capacidad de manejar las emociones.", "18-04-2021"),
        TestPsicologico("Test de Autoestima", "Evalúa el nivel de autoestima.", "25-05-2021"),
        TestPsicologico("Test de Estrés", "Mide el nivel de estrés de una persona.", "02-06-2021"),
        TestPsicologico("Test de Habilidades Sociales", "Evalúa las habilidades sociales y de comunicación.", "10-07-2021"),
        TestPsicologico("Test de Adicciones", "Identifica posibles adicciones y su severidad.", "15-08-2021"),
        TestPsicologico("Test de Resiliencia", "Mide la capacidad de una persona para recuperarse de situaciones difíciles.", "22-09-2021"),
        TestPsicologico("Test de Memoria", "Evalúa la capacidad de recordar información.", "30-10-2021")
    )

    Column(modifier = Modifier.padding(16.dp)) {
        Button(onClick = { mostrarLista = !mostrarLista }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "MOSTRAR / OCULTAR LISTA")
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (mostrarLista) {
            LazyColumn {
                items(listaDeTests) { test ->
                    TestCard(test)
                }
            }
        }
    }
}

@Composable
fun TestCard(test: TestPsicologico) {
    Card(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = test.titulo,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = test.descripcion,
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Publicado el: ${test.fechaPublicacion}",
                fontSize = 12.sp,
                fontWeight = FontWeight.Light,
                color = MaterialTheme.colorScheme.secondary
            )
        }
    }
}