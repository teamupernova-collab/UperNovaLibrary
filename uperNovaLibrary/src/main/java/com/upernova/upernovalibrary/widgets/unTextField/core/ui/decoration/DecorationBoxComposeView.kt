package com.example.textinputkitlibrary.core.uitextfield.decoration

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.textinputkitlibrary.utils.ui.DimensDp
import com.example.textinputkitlibrary.utils.ui.DimensDp.Dp8
import com.upernova.upernovalibrary.widgets.unTextField.core.base.TextFieldStatus

@Composable
fun DecorationBoxComposeView(
    innerTextField: @Composable () -> Unit,
    value: String,
    @DrawableRes endIcon: Int? = null,
    endIconAction: (() -> Unit)? = null,
    focusState: Boolean,
    textFieldStatus: TextFieldStatus,
) {
    ConstraintLayout(
        modifier = Modifier.wrapContentHeight()
    ) {

        val (textContainer) = createRefs()

        Box(
            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth()
                .height(48.dp)
                .border(
                    width = getUnderLineHeightBox(
                        focusState = focusState,
                        value = value
                    ),
                    color = getUnderLineBox(
                        focusState = focusState,
                        textFieldStatus = textFieldStatus
                    ),
                    shape = RoundedCornerShape(Dp8)
                )
                .constrainAs(textContainer) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        start = 16.dp,
                        end = 12.dp
                    )
            ) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp)
                ) {
                    innerTextField()
                }
                if (endIcon != null) {
                    IconButton(
                        onClick = {
                            endIconAction?.invoke()
                        },
                        modifier = Modifier.size(
                            DimensDp.Dp24
                        )
                    ) {
                        Icon(
                            painter = painterResource(
                                id = endIcon
                            ),
                            contentDescription = null,
                            tint = getUnderLineBox(
                                focusState = focusState,
                                textFieldStatus = textFieldStatus
                            )
                        )
                    }
                }
            }
        }
    }
}