void main() {
    try {
        new SmartDevice.Builder("1", "Sensor")
                .withMacAddress("123")
                .build();
    } catch (InvalidMacAddressException e) {
        IO.println(e.getMessage());
    }
}
