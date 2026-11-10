require ${@bb.utils.contains_any('AGL_FEATURES', 'agl-xen-dom0 agl-xen-domd', 'weston-ini-conf_agl-sodev-demo.inc', '', d)}
