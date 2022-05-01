import Foundation

protocol FoodDetailViewDelegate: AnyObject {
    func changingSelectedFoodCountRequested(value: Double)
}
