package com.example.euicompose

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.euicompose.components.MovieRow
import com.example.euicompose.datastore.DataStoreManager
import com.example.euicompose.datastore.settingsDataStore
import com.example.euicompose.network.RemoteDataSourceImpl
import com.example.euicompose.products.repo.ProductsRepositoryImpl
import com.example.euicompose.products.viewmodel.ProductsViewModel
import com.example.euicompose.products.viewmodel.ProductsViewModelFactory
import com.example.euicompose.screens.ProfileScreen
import com.example.euicompose.screens.Routes
import com.example.euicompose.settings.repo.SettingsRepositoryImpl
import com.example.euicompose.settings.view.SettingsScreen
import com.example.euicompose.settings.viewmodel.SettingsViewModel
import com.example.euicompose.settings.viewmodel.SettingsViewModelFactory
import com.example.euicompose.ui.theme.EUIComposeTheme

class MainActivity : ComponentActivity() {

    private val counterViewModel: CounterViewModel by viewModels()
    private val movieViewModel: MovieViewModel by viewModels()

    private val productsViewModel: ProductsViewModel by viewModels {
        ProductsViewModelFactory(
            repo = ProductsRepositoryImpl(
                remoteDataSource = RemoteDataSourceImpl()
            )
        )
    }

    private val settingsViewModel: SettingsViewModel by viewModels {
        SettingsViewModelFactory(
            repository = SettingsRepositoryImpl(
                dataStoreManager = DataStoreManager(this),
                settingsDataStoreProto = applicationContext.settingsDataStore,
            )
        )
    }

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val modifier = Modifier.fillMaxSize()

        setContent {
            val navController = rememberNavController()
            val backStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = backStackEntry?.destination?.route
            val isHome = currentDestination == Routes.Home::class.qualifiedName

            EUIComposeTheme {
                Scaffold(
                    modifier = modifier,
                    topBar = {
                        TopAppBar(
                            title = {
                                Text("Home")
                            },
                            navigationIcon = {
                                if (isHome.not()) {
                                    IconButton(
                                        onClick = {
                                            navController.popBackStack()
                                        }
                                    ) {
                                        Icon(Icons.AutoMirrored.Filled.ArrowBack, "Back")
                                    }
                                }
                            }
                        )
                    },
                    /*bottomBar = {
                        BottomNavigation(
                            backgroundColor = Color.White
                        ) {
                            BottomNavigationItem(
                                selected = currentDestination == Routes.Home::class.qualifiedName,
                                onClick = { navController.navigate(Routes.Home) },
                                icon = { Icon(Icons.Default.Home, null, tint = Color.Gray) },
                                label = { Text(text = "Home", color = Color.Gray) }
                            )
                            BottomNavigationItem(
                                selected = currentDestination == Routes.Profile::class.qualifiedName,
                                onClick = { navController.navigate(Routes.Profile(200, "Malek")) },
                                icon = { Icon(Icons.Default.Person, null, tint = Color.Gray) },
                                label = { Text(text = "Profile", color = Color.Gray) }
                            )
                        }
                    },*/
                    floatingActionButton = {
                        FloatingActionButton(
                            onClick = {
                                Toast.makeText(this, "FAB clicked!", Toast.LENGTH_SHORT).show()
                            }
                        ) {
                            Icon(Icons.Default.Add, "Add")
                        }
                    }
                ) { innerPadding ->

                    NavHost(
                        navController = navController,
                        startDestination = Routes.Home,
                        modifier = modifier.padding(innerPadding)
                    ) {
                        composable<Routes.Home> {
//                            DisplayOneHundredItems(movieViewModel)
                            /*HomeScreen { profile ->
                                navController.navigate(profile)
                            }*/
//                            ProductsScreen(productsViewModel)
//                            LaunchedEffectDemo()
//                            CounterWithSideEffect()
//                            AnimatedLifecycleScreen()
//                            TimerScreen()
//                            DerivedStateExample()
//                            DebouncedSearchExample()
                            SettingsScreen(viewModel = settingsViewModel)
                        }
                        composable<Routes.Profile> { backStackEntry ->
                            val profile: Routes.Profile = backStackEntry.toRoute()
                            ProfileScreen(profile) {
                                navController.popBackStack()
                            }
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DisplayOneHundredItems(
    movieViewModel: MovieViewModel,
    modifier: Modifier = Modifier
) {

    val listOfData by movieViewModel.movieList.collectAsStateWithLifecycle()
    movieViewModel.getPopularMovies1()

    val listOfData2 by movieViewModel.movieList2.collectAsStateWithLifecycle()
    movieViewModel.getPopularMovies2()

    LazyColumn(
        modifier = modifier
            .padding(16.dp)
    ) {
        /*
        * array
        * list
        * collection --> count
        * */
        stickyHeader {
//            CustomHeader("Odd Numbers")
            CustomHeader("Foreign Movies")
        }
        /*items(100) { index ->
            if (index % 2 != 0) {
                MovieRow(index)
            }
        }*/
        items(listOfData) { movie ->
            MovieRow(movie)
        }

        stickyHeader {
//            CustomHeader("Even Numbers")
            CustomHeader("Arabic Movies")
        }
        /*items(100) { index ->
            if (index % 2 == 0) {
                MovieRow(index)
            }
        }*/
        items(listOfData2) { movie ->
            MovieRow(movie)
        }

        item {
            CustomHeader("End Of File")
        }

        /*
        val names = listOf("Nouran", "Zeyad", "Lamiaa", "Mohamed", "Ahmed", "Menna", "Abdulrahman", "Yasmine", "Ihab")
        items(movies) { name ->
            Text(
                text = "Name: $name"
            )
        }*/
    }
}

@Composable
fun CustomHeader(title: String) {
    Card(
        modifier = Modifier.padding(start = 8.dp, end = 8.dp, bottom = 8.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Text(
            text = title,
            color = Color(0xFF123456),
            modifier = Modifier.padding(8.dp),
            style = MaterialTheme.typography.titleLarge
        )
    }
}

@Composable
fun EmailTextField(modifier: Modifier = Modifier) {

    var emailValue by rememberSaveable { mutableStateOf("") }

    TextField(
        value = emailValue,
        onValueChange = { newValue ->
            emailValue = newValue
        },
        label = {
            Text(text = "Email")
        },
        modifier = modifier
    )
}

@Composable
fun StatefulCounter(
    viewModel: CounterViewModel,
    modifier: Modifier = Modifier
) {

    val count by viewModel.count.collectAsStateWithLifecycle()

//    val isEven by rememberSaveable { derivedStateOf { count % 2 == 0 } }

    StatelessCounter(
        count = count,
        isEven = true,
        modifier = modifier,
        onButtonClicked = {
            viewModel.increment()
        }
    )

    /*Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Counter = $count"
        )

        Spacer(Modifier.height(8.dp))

        Button(
            onClick = {
                count++ // () -> Unit
            }
        ) {
            Text(text = "Click Me")
        }
    }*/
}

@Composable
fun StatelessCounter(count: Int, isEven: Boolean, modifier: Modifier = Modifier, onButtonClicked: () -> Unit) {

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Counter = $count"
        )
        Spacer(Modifier.height(4.dp))
        Text(
            text = "Is Even = $isEven"
        )

        Spacer(Modifier.height(8.dp))

        Button(
            onClick = onButtonClicked
        ) {
            Text(text = "Click Me")
        }
    }
}

@Composable
fun Counter(modifier: Modifier = Modifier) {
    var count by remember { mutableStateOf(0) }

    Column(
        modifier = modifier
    ) {
        Text(
            text = "You have clicked the button $count times",
        )

        Spacer(modifier.height(16.dp))

        Button(
            onClick = {
                count++
                Log.d("asd --> ", "Counter = $count")
            }
        ) {
            Text("Increase")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CounterPreview() {
    EUIComposeTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Counter(
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    EUIComposeTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Greeting(
                name = "Android",
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}
