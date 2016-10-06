package CMPS_3240_6240Fall16

/**
  * Created by Parisa on 9/13/16.
  */
import CMPS_3240_6240Fall16.BadgeClassifiers._
import Readers.BadgeReader
import scala.collection.JavaConversions._
object BadgesApp extends App{

  val allNamesTrain= new BadgeReader("data/badges/badges.train").badges
  val allNamesTest= new BadgeReader("data/badges/badges.test").badges

  BadgeDataModel.badge.populate(allNamesTrain)
  BadgeDataModel.badge.populate(allNamesTest,false)

  BadgeClassifier.learn(5)
  BadgeClassifier.test()
}