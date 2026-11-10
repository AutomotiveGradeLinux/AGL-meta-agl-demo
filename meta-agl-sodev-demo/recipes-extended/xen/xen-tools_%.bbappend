require ${@bb.utils.contains('AGL_FEATURES', 'agl-sodev-demo agl-xen-domd', 'xen-tools_agl-sodev-demo.inc', '', d)}
