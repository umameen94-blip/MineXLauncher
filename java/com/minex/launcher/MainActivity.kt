
package com.minex.launcher

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val versions = listOf(
    "Latest Release",
    "Latest Snapshot",
    "1.21.11",
    "1.21.10",
    "1.21.9",
    "1.20.6",
    "1.20.4",
    "1.19.4",
    "1.18.2",
    "1.16.5",
    "1.12.2",
    "1.8.9",
    "Beta",
    "Alpha"
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MineXApp()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MineXApp() {
    var selectedVersion by remember {
        mutableStateOf("Latest Release")
    }

    var ram by remember {
        mutableFloatStateOf(2f)
    }

    var accountStatus by remember {
        mutableStateOf("Not signed in")
    }

    MaterialTheme(
        colorScheme = darkColorScheme(
            primary = Color(0xFF55D6BE),
            secondary = Color(0xFF8AA4FF),
            background = Color(0xFF10151D),
            surface = Color(0xFF1B2430)
        )
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFF10151D)
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                verticalArrangement =
                    Arrangement.spacedBy(16.dp)
            ) {
                item {
                    Text(
                        "MineX",
                        color = Color(0xFF55D6BE),
                        fontSize = 34.sp,
                        fontWeight = FontWeight.ExtraBold
                    )

                    Text(
                        "MINECRAFT JAVA LAUNCHER",
                        color = Color.LightGray,
                        fontSize = 12.sp
                    )
                }

                item {
                    Panel("GAME VERSION") {
                        var expanded by remember {
                            mutableStateOf(false)
                        }

                        ExposedDropdownMenuBox(
                            expanded = expanded,
                            onExpandedChange = {
                                expanded = !expanded
                            }
                        ) {
                            OutlinedTextField(
                                value = selectedVersion,
                                onValueChange = {},
                                readOnly = true,
                                label = {
                                    Text("Select version")
                                },
                                trailingIcon = {
                                    ExposedDropdownMenuDefaults
                                        .TrailingIcon(expanded)
                                },
                                modifier = Modifier
                                    .menuAnchor()
                                    .fillMaxWidth()
                            )

                            ExposedDropdownMenu(
                                expanded = expanded,
                                onDismissRequest = {
                                    expanded = false
                                }
                            ) {
                                versions.forEach { version ->
                                    DropdownMenuItem(
                                        text = { Text(version) },
                                        onClick = {
                                            selectedVersion = version
                                            expanded = false
                                        }
                                    )
                                }
                            }
                        }

                        Text(
                            "Version selector preview",
                            color = Color.LightGray
                        )
                    }
                }

                item {
                    Panel("MEMORY") {
                        Text(
                            "${ram.toInt()} GB RAM",
                            color = Color.White
                        )

                        Slider(
                            value = ram,
                            onValueChange = { ram = it },
                            valueRange = 1f..6f,
                            steps = 4
                        )
                    }
                }

                item {
                    Panel("ACCOUNT") {
                        Text(
                            accountStatus,
                            color = Color.White
                        )

                        Button(
                            onClick = {
                                accountStatus =
                                    "Microsoft login not implemented yet"
                            },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text("Microsoft Account")
                        }

                        OutlinedButton(
                            onClick = {
                                accountStatus =
                                    "Offline mode selected"
                            },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text("Continue Offline")
                        }
                    }
                }

                item {
                    Button(
                        onClick = {},
                        enabled = false,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(54.dp)
                    ) {
                        Text("PLAY")
                    }

                    Text(
                        "Game engine is not implemented yet.",
                        color = Color.LightGray,
                        fontSize = 12.sp
                    )
                }
            }
        }
    }
}

@Composable
fun Panel(
    title: String,
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF1B2430)
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(
                title,
                color = Color(0xFF55D6BE),
                fontWeight = FontWeight.Bold
            )

            content()
        }
    }
}
