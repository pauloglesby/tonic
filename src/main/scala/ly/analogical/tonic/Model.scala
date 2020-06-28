package ly.analogical.tonic

object Model {

  type Interval = Pitch => Int => Pitch

  // 1
  sealed trait Sound
  sealed trait Pitch extends Sound
  final case class Note(pitch: Pitch) extends Sound // could also be called Monad, but that's obviously semantically overloaded here!
  final case class Dyad(pitch: Pitch, interval: Interval) extends Sound
  final case class Triad(pitch: Pitch, firstInterval: Interval, secondInterval: Interval) extends Sound

  // 2
  sealed trait Sound2
  final case class Pitch2(value: String) extends Sound2 // instead of string, make this an enum
  final case class PitchAnd(pitch: Pitch, sound: Sound2) extends Sound2

  // Directions
  // 1. What about e.g. 7#9 chords as a dominant 7th (root, 7) and major 7th (3rd, #9th), whose "roots" are separated by a major 3rd
  final case class Stack(interval: Interval, sound: Sound2) extends Sound2
  final case class Complex(s1: Sound2, s2: Sound2) extends Sound2

}
