package com.example.contactapp.presentation.utils

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.VisualTransformation


@Composable
fun CustomTextField(
    value : String,
    onValueChange : (String) -> Unit,
    label : String,
    modifier : Modifier = Modifier,
    singeLine : Boolean = true,
    leadingIcon :  ImageVector? = null,
    visualTransformation : VisualTransformation = VisualTransformation.None,
    keyboardOptions : KeyboardOptions = KeyboardOptions.Default,

){
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = @Composable { Text(text = label) },
        colors = TextFieldDefaults.colors(
            focusedTextColor = MaterialTheme.colorScheme.onSurface,
            unfocusedTextColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f),
            focusedIndicatorColor = MaterialTheme.colorScheme.primary,
            unfocusedIndicatorColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f),
            cursorColor = MaterialTheme.colorScheme.primary,
            focusedLabelColor = MaterialTheme.colorScheme.primary,
            focusedLeadingIconColor = MaterialTheme.colorScheme.primary,
            focusedPlaceholderColor = MaterialTheme.colorScheme.onSurface,
            disabledLeadingIconColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f),
        ),
        modifier = modifier,
        singleLine = singeLine,
        leadingIcon = leadingIcon?.let { icon ->
            @androidx.compose.runtime.Composable {
                Icon(imageVector = icon, contentDescription = null)
            }
        },
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,

    )
}