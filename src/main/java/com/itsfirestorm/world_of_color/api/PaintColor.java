package com.itsfirestorm.world_of_color.api;

public enum PaintColor {
    RED("red", 0xFF5A3A), BLUE("blue", 0x3789FD), GREEN("green", 0x0FB009),
    YELLOW("yellow", 0xFDDE1A), PINK("pink", 0xE89DC9), PURPLE("purple", 0x9B5DCC),
    MAGENTA("magenta", 0xD673D0), LIME("lime", 0x84F725), CYAN("cyan", 0x4CBCC0),
    LIGHTBLUE("light_blue", 0x77B8EC), ORANGE("orange", 0xFEAC3A), BROWN("brown", 0xB9754E),
    LIGHTGRAY("light_gray", 0xAAAAB0), GRAY("gray", 0x808086), BLACK("black", 0x50597C),
    WHITE("white", 0xFFFFFF);

    private final String id;
    private final int color;

    PaintColor(String id, int color) {
        this.id = id;
        this.color = color;
    }

    public String getId() { return id; }
    public int getColor() { return color; }
}
