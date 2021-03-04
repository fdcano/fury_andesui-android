package com.mercadolibre.android.andesui.tooltip.location

sealed class AndesTooltipArrowLocation {
    internal abstract fun getArrowPositionX(tooltip: AndesTooltipLocationInterface): Float
    internal abstract fun getArrowPositionY(tooltip: AndesTooltipLocationInterface): Float
}

internal object AndesTooltipArrowBottomLeft : AndesTooltipArrowLocation() {
    override fun getArrowPositionX(tooltip: AndesTooltipLocationInterface): Float {
        return tooltip.arrowBorder.toFloat()
    }

    override fun getArrowPositionY(tooltip: AndesTooltipLocationInterface): Float {
        return tooltip.frameLayoutContainer.y + tooltip.radiusLayout.height - tooltip.elevation
    }
}
internal object AndesTooltipArrowBottomMiddle : AndesTooltipArrowLocation() {
    override fun getArrowPositionX(tooltip: AndesTooltipLocationInterface): Float {
        return ((tooltip.frameLayoutContainer.width / 2) - (tooltip.arrowWidth / 2)).toFloat()
    }

    override fun getArrowPositionY(tooltip: AndesTooltipLocationInterface): Float {
        return tooltip.frameLayoutContainer.y + tooltip.radiusLayout.height - tooltip.elevation
    }
}
internal object AndesTooltipArrowBottomRight : AndesTooltipArrowLocation() {
    override fun getArrowPositionX(tooltip: AndesTooltipLocationInterface): Float {
        return (tooltip.frameLayoutContainer.width - tooltip.arrowBorder - tooltip.arrowWidth).toFloat()
    }

    override fun getArrowPositionY(tooltip: AndesTooltipLocationInterface): Float {
        return tooltip.frameLayoutContainer.y + tooltip.radiusLayout.height - tooltip.elevation
    }
}

internal object AndesTooltipArrowTopLeft : AndesTooltipArrowLocation() {
    override fun getArrowPositionX(tooltip: AndesTooltipLocationInterface): Float {
        return tooltip.arrowBorder.toFloat()
    }

    override fun getArrowPositionY(tooltip: AndesTooltipLocationInterface): Float {
        return tooltip.radiusLayout.y - tooltip.arrowBorder
    }
}
internal object AndesTooltipArrowTopMiddle : AndesTooltipArrowLocation() {
    override fun getArrowPositionX(tooltip: AndesTooltipLocationInterface): Float {
        return ((tooltip.frameLayoutContainer.width / 2) - (tooltip.arrowWidth / 2)).toFloat()
    }

    override fun getArrowPositionY(tooltip: AndesTooltipLocationInterface): Float {
        return tooltip.radiusLayout.y - tooltip.arrowBorder
    }
}
internal object AndesTooltipArrowTopRight : AndesTooltipArrowLocation() {
    override fun getArrowPositionX(tooltip: AndesTooltipLocationInterface): Float {
        return (tooltip.frameLayoutContainer.width - tooltip.arrowBorder - tooltip.arrowWidth).toFloat()
    }

    override fun getArrowPositionY(tooltip: AndesTooltipLocationInterface): Float {
        return tooltip.radiusLayout.y - tooltip.arrowBorder
    }
}

internal object AndesTooltipArrowRightTop : AndesTooltipArrowLocation() {
    override fun getArrowPositionX(tooltip: AndesTooltipLocationInterface): Float {
        return tooltip.frameLayoutContainer.x + tooltip.radiusLayout.width - tooltip.elevation - tooltip.arrowImageInnerPadding
    }

    override fun getArrowPositionY(tooltip: AndesTooltipLocationInterface): Float {
        return tooltip.arrowBorder.toFloat()
    }
}
internal object AndesTooltipArrowRightMiddle : AndesTooltipArrowLocation() {
    override fun getArrowPositionX(tooltip: AndesTooltipLocationInterface): Float {
        return tooltip.frameLayoutContainer.x + tooltip.radiusLayout.width - tooltip.elevation - tooltip.arrowImageInnerPadding
    }

    override fun getArrowPositionY(tooltip: AndesTooltipLocationInterface): Float {
        return ((tooltip.frameLayoutContainer.height / 2) - (tooltip.arrowWidth / 2)).toFloat()
    }
}
internal object AndesTooltipArrowRightBottom : AndesTooltipArrowLocation() {
    override fun getArrowPositionX(tooltip: AndesTooltipLocationInterface): Float {
        return tooltip.frameLayoutContainer.x + tooltip.radiusLayout.width - tooltip.elevation - tooltip.arrowImageInnerPadding
    }

    override fun getArrowPositionY(tooltip: AndesTooltipLocationInterface): Float {
        return (tooltip.frameLayoutContainer.height - tooltip.arrowBorder - tooltip.arrowWidth).toFloat()
    }
}

internal object AndesTooltipArrowLeftTop : AndesTooltipArrowLocation() {
    override fun getArrowPositionX(tooltip: AndesTooltipLocationInterface): Float {
        return tooltip.frameLayoutContainer.x
    }

    override fun getArrowPositionY(tooltip: AndesTooltipLocationInterface): Float {
        return tooltip.arrowBorder.toFloat()
    }
}
internal object AndesTooltipArrowLeftMiddle : AndesTooltipArrowLocation() {
    override fun getArrowPositionX(tooltip: AndesTooltipLocationInterface): Float {
        return tooltip.frameLayoutContainer.x
    }

    override fun getArrowPositionY(tooltip: AndesTooltipLocationInterface): Float {
        return ((tooltip.frameLayoutContainer.height / 2) - (tooltip.arrowWidth / 2)).toFloat()
    }
}
internal object AndesTooltipArrowLeftBottom : AndesTooltipArrowLocation() {
    override fun getArrowPositionX(tooltip: AndesTooltipLocationInterface): Float {
        return tooltip.frameLayoutContainer.x
    }

    override fun getArrowPositionY(tooltip: AndesTooltipLocationInterface): Float {
        return (tooltip.frameLayoutContainer.height - tooltip.arrowBorder - tooltip.arrowWidth).toFloat()
    }
}

enum class ArrowPositionId {
    TOP,
    LEFT,
    RIGHT,
    BOTTOM,
    MIDDLE
}

internal fun getAndesTooltipArrowLocation(tooltipSideId: ArrowPositionId, positionInSideId: ArrowPositionId): AndesTooltipArrowLocation =
        when (tooltipSideId to positionInSideId) {
            ArrowPositionId.BOTTOM to ArrowPositionId.LEFT -> AndesTooltipArrowBottomLeft
            ArrowPositionId.BOTTOM to ArrowPositionId.MIDDLE -> AndesTooltipArrowBottomMiddle
            ArrowPositionId.BOTTOM to ArrowPositionId.RIGHT -> AndesTooltipArrowBottomRight

            ArrowPositionId.TOP to ArrowPositionId.LEFT -> AndesTooltipArrowTopLeft
            ArrowPositionId.TOP to ArrowPositionId.MIDDLE -> AndesTooltipArrowTopMiddle
            ArrowPositionId.TOP to ArrowPositionId.RIGHT -> AndesTooltipArrowTopRight

            ArrowPositionId.RIGHT to ArrowPositionId.TOP -> AndesTooltipArrowRightTop
            ArrowPositionId.RIGHT to ArrowPositionId.MIDDLE -> AndesTooltipArrowRightMiddle
            ArrowPositionId.RIGHT to ArrowPositionId.BOTTOM -> AndesTooltipArrowRightBottom

            ArrowPositionId.LEFT to ArrowPositionId.TOP -> AndesTooltipArrowLeftTop
            ArrowPositionId.LEFT to ArrowPositionId.MIDDLE -> AndesTooltipArrowLeftMiddle
            ArrowPositionId.LEFT to ArrowPositionId.BOTTOM -> AndesTooltipArrowLeftBottom

            else -> AndesTooltipArrowBottomLeft
        }
