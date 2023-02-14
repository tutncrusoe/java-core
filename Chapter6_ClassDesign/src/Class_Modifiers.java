public class Class_Modifiers {
}

final class Rhinoceros extends Class_Modifiers { // The final modifier prevents a class from being extended any further
}

class Clara extends Rhinoceros { // DOES NOT COMPILE
}

