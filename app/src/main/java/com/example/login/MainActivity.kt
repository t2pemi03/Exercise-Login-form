package com.example.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.login.ui.theme.LoginTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginTheme {
                Login()
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login() {
    var UsernameText by remember { mutableStateOf("") }
    var PasswordText by remember { mutableStateOf("") }
    var PasswordVisiuble by remember { mutableStateOf(false) }

    Column(modifier = Modifier.padding(16.dp)) {


        TextField(
            value = UsernameText,
            onValueChange = { UsernameText = it },
            label = { Text(text = "Username") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            trailingIcon = {
                Icon(imageVector = Icons.Filled.Email, contentDescription ="" )
            }
        )

        TextField(
            value = PasswordText,
            onValueChange = { PasswordText = it },
            label = { Text(text = "Password") },
            singleLine = true,
            placeholder = { Text(text = "Password") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = if (PasswordVisiuble) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = { PasswordVisiuble = !PasswordVisiuble }) {

                    Icon(
                        imageVector = if (PasswordVisiuble) Icons.Filled.Info else Icons.Filled.Lock,
                        contentDescription = if (PasswordVisiuble) "Hide password" else "Show password"
                    )
                }
            }
        )


        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text(text = "Submit")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LoginTheme {
        Login()
    }
}
