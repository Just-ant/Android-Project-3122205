package com.griffith.littlealiens

import android.R.attr.onClick
import android.os.Bundle
import android.util.Log.i
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.R
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.griffith.littlealiens.ui.theme.LittleAliensTheme
import com.griffith.littlealiens.ui.theme.Purple40
import com.griffith.littlealiens.ui.theme.Purple80
import com.griffith.littlealiens.ui.theme.LittleAliensTheme
import com.griffith.littlealiens.ui.theme.Purple40
import com.griffith.littlealiens.ui.theme.Purple80

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LittleAliensTheme {
                Column{

                    ExtendedFloatingActionButton(
                        shape = CircleShape,
                        contentColor = Purple80,
                        containerColor = Purple40, onClick={}) {
                        Icon(
                            painter = painterResource(id = R.drawable.little_guy),
                            contentDescription = "House",
                            modifier = Modifier.size(100.dp),
                        )
                        Text("Little aliens", fontSize = 50.sp)

                    }

                    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                        for(i in 0.. 100){
                            Text("option $i")
                        }
                    }
                    DropdownMenuExample()
                }


            }
        }
    }

    @Composable
    fun DropdownMenuExample(){
        var expanded by remember {mutableStateOf(false)}
        Box(modifier=Modifier.fillMaxSize().wrapContentSize(Alignment.TopStart)){
            IconButton(onClick = {expanded = true}) {
                Icon(painter = painterResource(id=R.drawable.add), contentDescription = "menu")
            }
            DropdownMenu(expanded = expanded, onDismissRequest = {expanded=false}){
                DropdownMenuItem({Text("Go somehwere")}, onClick = {})
                DropdownMenuItem({Text("come back")}, onClick = {})
            }
        }
    }
}