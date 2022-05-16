package com.vku.learnzone.view

import android.widget.Space
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import com.vku.learnzone.R
import com.vku.learnzone.ui.theme.*
import com.vku.learnzone.viewmodel.CourseViewModel

@Composable
fun HomeScreen(viewModel: CourseViewModel) {
    LaunchedEffect(Unit, block = {
        viewModel.getCourseList()
    })

    Box(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        ConstraintLayout {
            val (logoimageref, loginformref) = createRefs()

            Box(contentAlignment = Alignment.Center,
                modifier = Modifier
                    .height(100.dp)
                    .constrainAs(logoimageref) {
                        top.linkTo(loginformref.top)
                        bottom.linkTo(loginformref.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            ) {
                HeaderHome()
            }

            Surface(
                color = ghost_white,
                shape = RoundedCornerShape(40.dp).copy(
                    bottomStart = ZeroCornerSize,
                    bottomEnd = ZeroCornerSize
                ),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 15.dp)
                    .constrainAs(loginformref) {
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp)
                ) {
                    PromotionSection()
                    AwesomeCoursesSection()
                }
            }
        }
    }
//    Scaffold(
//        topBar = {
//            TopAppBar(
//                title = {
//                    Row() {
//                        Text("Todos")
//                    }
//                })
//        },
//        content = {
//            if (viewModel.errorMessage.isEmpty()) {
//                Column(modifier = Modifier.padding(16.dp)) {
//                    LazyColumn(modifier = Modifier.fillMaxHeight()) {
//                        items(viewModel.courseList) { course ->
//                            Column {
//                                Row(
//                                    modifier = Modifier
//                                        .fillMaxWidth()
//                                        .padding(16.dp),
//                                    horizontalArrangement = Arrangement.SpaceBetween
//                                ) {
//                                    Box(
//                                        modifier = Modifier
//                                            .fillMaxWidth()
//                                            .padding(0.dp, 0.dp, 16.dp, 0.dp)
//                                    ) {
//                                        Text(
//                                            course.title,
//                                            maxLines = 1,
//                                            overflow = TextOverflow.Ellipsis
//                                        )
//                                    }
//                                }
//                                Divider()
//                            }
//                        }
//                    }
//                }
//            } else {
//                Text(viewModel.errorMessage)
//            }
//        }
//    )
}

@Composable
fun HeaderHome() {
    Image(
        painter = painterResource(id = R.drawable.login_bg),
        contentDescription = "login_bg",
        contentScale = ContentScale.FillWidth,
        modifier = Modifier.fillMaxSize()
    )
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box(modifier = Modifier.height(1.dp))
        Text(
            text = "LearnZone",
            color = white,
            fontSize = 24.sp,
            letterSpacing = 2.sp,
//            modifier = Modifier.padding(horizontal = 100.dp)
        )
        IconButton(onClick = {}) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
                tint = white,
                modifier = Modifier.size(32.dp, 32.dp)
            )
        }
    }
}

@Composable
fun PromotionSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Promotion",
            style = MaterialTheme.typography.h6,
            fontWeight = FontWeight.Bold
        )
        TextButton(onClick = {}) {
            Text(
                text = "See all",
                color = colorPrimary,
                fontWeight = FontWeight.Bold
            )
        }
    }
    Spacer(modifier = Modifier.padding(10.dp))
    Image(
        painter = painterResource(id = R.drawable.ic_sale_banner),
        contentDescription = "",
        contentScale = ContentScale.FillWidth,
        modifier = Modifier.fillMaxWidth()
    )
    Spacer(modifier = Modifier.padding(10.dp))
}

@Composable
fun AwesomeCoursesSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Awesome Courses",
            style = MaterialTheme.typography.h6,
            fontWeight = FontWeight.Bold
        )
        TextButton(onClick = {}) {
            Text(
                text = "See all",
                color = colorPrimary,
                fontWeight = FontWeight.Bold
            )
        }
    }
    Spacer(modifier = Modifier.padding(10.dp))
    CourseItems()
}

@Composable
fun CourseItems() {
    // container
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        for (i in 1..2) {
            // item
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .background(white)
            ) {
                // Image
                AsyncImage(
                    modifier = Modifier
                        .size(100.dp)
                        .padding(16.dp),
                    model = "https://store.soft365.vn/wp-content/uploads/2018/10/logo-2.png",
                    contentDescription = null
                )
                // Title + Price
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(end = 16.dp)
                ) {
                    // Title
                    Column {
                        Text(
                            text = "3D Design Basic",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = black
                        )
                        Spacer(
                            modifier = Modifier
                                .height(6.dp)
                        )
                        Text(
                            text = "24 lessons",
                            fontSize = 11.sp,
                            color = gray,
                            fontWeight = FontWeight.Light
                        )
                        Spacer(
                            modifier = Modifier
                                .height(6.dp)
                        )
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Star,
                                contentDescription = "Start",
                                tint = colorPrimary,
                                modifier = Modifier
                                    .size(16.dp)
                            )
                            Text(
                                text = "4.9",
                                fontSize = 10.sp,
                                color = gray,
                                fontWeight = FontWeight.Light
                            )
                        }
                    }
                    // Price
                    Column(
                        horizontalAlignment = Alignment.End
                    ) {
                        Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = "Favorite",
                            tint = colorPrimary
                        )
                        Spacer(
                            modifier = Modifier
                                .height(6.dp)
                        )
                        Text(
                            text = "$24.99",
                            fontSize = 16.sp,
                            color = colorPrimary,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}
