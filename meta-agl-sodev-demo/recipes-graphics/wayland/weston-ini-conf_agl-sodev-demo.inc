# Fixup a hard addition, some things need to be reworked
# to avoid needing to do this.
WESTON_FRAGMENTS_BASE:remove = "${@bb.utils.contains_any('AGL_FEATURES', 'agl-xen-dom0 agl-xen-domd', 'grpc-proxy', '', d)}"
