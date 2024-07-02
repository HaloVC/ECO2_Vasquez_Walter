package pe.edu.idat.eco2_vasquez_walter

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Formulario() {
    val platosFavoritos = listOf("Arroz con pollo", "Lomo Saltado", "Ají de gallina", "Tallarines", "Arroz Chaufa", "Otro")
    val checkedState = remember { mutableStateMapOf<String, Boolean>().apply { platosFavoritos.forEach { this[it] = false } } }

    var visitedCountries by remember { mutableStateOf("") }
    var speaksEnglish by remember { mutableStateOf("") }
    var likesTechnology by remember { mutableStateOf("") }
    var worksRemotely by remember { mutableStateOf("") }

    Box(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())
        .padding(16.dp)) {
        Column {
            Text(
                text = "CUESTIONARIO",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Text(text = "1. Marque sus platos favoritos.", fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            platosFavoritos.forEach { dish ->
                CheckboxRow(label = dish, checked = checkedState[dish] ?: false) { isChecked ->
                    checkedState[dish] = isChecked
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            QuestionRadioGroup(
                question = "2. ¿Visitaste algún país de Europa, Asia o África?",
                selectedOption = visitedCountries,
                onOptionSelected = { visitedCountries = it }
            )
            QuestionRadioGroup(
                question = "3. ¿Hablas Inglés?",
                selectedOption = speaksEnglish,
                onOptionSelected = { speaksEnglish = it }
            )
            QuestionRadioGroup(
                question = "4. ¿Te gusta la tecnología?",
                selectedOption = likesTechnology,
                onOptionSelected = { likesTechnology = it }
            )
            QuestionRadioGroup(
                question = "5. ¿Realizas trabajo remoto?",
                selectedOption = worksRemotely,
                onOptionSelected = { worksRemotely = it }
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = { /* Acción al resolver */ }) {
                Text("Resolver")
            }
        }
    }
}

@Composable
fun CheckboxRow(label: String, checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 4.dp)) {
        Checkbox(checked = checked, onCheckedChange = onCheckedChange)
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = label)
    }
}

@Composable
fun QuestionRadioGroup(question: String, selectedOption: String, onOptionSelected: (String) -> Unit) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 8.dp)) {
        Text(text = question, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(4.dp))
        Row {
            RadioButton(selected = selectedOption == "SI", onClick = { onOptionSelected("SI") })
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = "SI")
            Spacer(modifier = Modifier.width(16.dp))
            RadioButton(selected = selectedOption == "NO", onClick = { onOptionSelected("NO") })
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = "NO")
        }
    }
}
