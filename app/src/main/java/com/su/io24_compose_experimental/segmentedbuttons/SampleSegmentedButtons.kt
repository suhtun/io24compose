package com.su.io24_compose_experimental.segmentedbuttons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MultiChoiceSegmentedButtonRow
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/*
SingleChoiceSegmentedButtonRow {numbers.forEachIndexed { index, num ->
                SegmentedButton(
                    selected = selectedIndexNumber == index,
                    onClick = { selectedIndexNumber = index },
                    shape = SegmentedButtonDefaults.itemShape(index = index, count = numbers.size)
                ) {Text(text = num)}
            }
        }
* */
/*
MultiChoiceSegmentedButtonRow {
            vegetables.forEachIndexed { index, vegetable ->
                SegmentedButton(
                    shape = SegmentedButtonDefaults.itemShape(index = index,count = vegetables.size),
                    checked = index in checkedList,
                    onCheckedChange = {if (it) checkedList.add(index) else checkedList.remove(index)
                    ) {Text(text = vegetable)}
            }
        }
* */

@Composable
fun SampleSegmentedButtons(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val numbers = listOf("One", "Two", "Three")
        var selectedIndexNumber by remember {
            mutableStateOf(0)
        }
        SingleChoiceSegmentedButtonRow {
            numbers.forEachIndexed { index, s ->
                SegmentedButton(
                    selected = index == selectedIndexNumber,
                    onClick = { selectedIndexNumber = index }, shape =
                    SegmentedButtonDefaults.itemShape(index = index, count = numbers.size)
                ) {

                }
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        val vegetables = listOf("Tomato", "Potato", "Onion")
        var checkedList = remember {
            mutableStateListOf<Int>()
        }
        MultiChoiceSegmentedButtonRow {
            vegetables.forEachIndexed { index, vege ->
                SegmentedButton(checked = index in checkedList,
                    onCheckedChange = {
                        if (it) checkedList.add(index) else checkedList.remove(index)
                    },
                    shape = SegmentedButtonDefaults.itemShape(
                        index = index,
                        count = vegetables.size
                    )
                ) {

                }
            }
        }
    }
}