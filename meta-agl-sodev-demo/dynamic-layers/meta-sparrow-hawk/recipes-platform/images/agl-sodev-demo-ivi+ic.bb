require dynamic-layers/meta-sparrow-hawk/recipes-platform/images/agl-xen-v4h-image.bb

IMAGE_INSTALL += " \
    agl-v4h-ivi-domu-conf \
    agl-v4h-ic-domu-conf \
"

DOMU_IMAGES = "agl-xen-domu:agl-ivi-demo-flutter agl-xen-domu:agl-cluster-demo-flutter"

DOM_NAME_agl-ivi-demo-flutter = "domu-agl-ivi"
DOM_LABEL_agl-ivi-demo-flutter = "domu-agl-ivi-rootfs"

DOM_NAME_agl-cluster-demo-flutter = "domu-agl-ic"
DOM_LABEL_agl-cluster-demo-flutter = "domu-agl-ic-rootfs"