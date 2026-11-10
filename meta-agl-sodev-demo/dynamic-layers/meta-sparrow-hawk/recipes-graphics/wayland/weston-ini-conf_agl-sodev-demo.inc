FILESEXTRAPATHS:prepend := "${THISDIR}/weston-ini-conf:"

SRC_URI += "file://dp-1-0.cfg \
            file://dsi-1-0.cfg \
"

WESTON_DISPLAYS = "dp-1-0 dsi-1-0 hdmi-a-1-0"

# Fixup for a hard addition, some things need to be reworked
# to avoid needing to do this.
WESTON_FRAGMENTS:remove = "sparrow-hawk_output"
