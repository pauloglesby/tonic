package ly.analogical.tonic

object Model {

  type Interval = Pitch => Int => Pitch

  sealed trait Sound
  sealed trait Pitch extends Sound
  final case class Note(pitch: Pitch) extends Sound // could also be called Monad, but that's obviously semantically overloaded here!
  final case class Dyad(pitch: Pitch, interval: Interval) extends Sound
  final case class Triad(pitch: Pitch, firstInterval: Interval, secondInterval: Interval) extends Sound

}
