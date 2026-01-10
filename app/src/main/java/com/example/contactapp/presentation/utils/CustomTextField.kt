package com.example.contactapp.presentation.utils

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.VisualTransformation
import androidx.wear.compose.material.ContentAlpha

@Composable
fun CustomTextField(
    value : String,
    onValueChange : (String) -> Unit,
    label : String,
    modifier : Modifier = Modifier,
    singleLine : Boolean = true,
    leadingIcon :  ImageVector? = null,
    visualTransformation : VisualTransformation = VisualTransformation.None,
    keyboardOptions : KeyboardOptions = KeyboardOptions.Default,

){
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = label,
        modifier = modifier,
        singleLine = singleLine,
        leadingIcon =leadingIcon?.let {
            icon ->{
                Icon(imageVector = icon, contentDescription = null)
        }
        },
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        colors = TextFieldDefaults.colors(
            focusedTextColor = MaterialTheme.colorScheme.onSurface,
            unfocusedTextColor = MaterialTheme.colorScheme.onSurface.copy(alpha = ContentAlpha.disabled),
            focusedIndicatorColor = MaterialTheme.colorScheme.primary,
            unfocusedIndicatorColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f),
            cursorColor =  MaterialTheme.colorScheme.primary,
            focusedLabelColor = MaterialTheme.colorScheme.primary,
            focusedLeadingIconColor =  MaterialTheme.colorScheme.primary,
            focusedPlaceholderColor =  MaterialTheme.colorScheme.onSurface.copy(alpha = ContentAlpha.medium),
            disabledLeadingIconColor =  MaterialTheme.colorScheme.onSurface.copy(alpha = ContentAlpha.medium),
        ),

    ){

    }
}