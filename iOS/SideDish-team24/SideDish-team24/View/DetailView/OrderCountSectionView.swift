import UIKit

class OrderCountSectionView: UIView {
        
    private var countTitle = CustomLabel(title: "수량", font: .smallRegular, color: .dishGrey2)
    
    private var counter: UILabel = CustomLabel(title: "1", font: .mediumBold, color: .dishGrey1)
    
    private var stepper: UIStepper = {
        let stepper = UIStepper()
        stepper.translatesAutoresizingMaskIntoConstraints = false
        stepper.minimumValue = 1
        return stepper
    }()
    
    private let stepperTouched: UIAction = UIAction(handler: { action in
        guard let sender = action.sender as? UIStepper else { return }
        NotificationCenter.default.post(name: .stepperTouched,
                                        object: nil,
                                        userInfo: [NotificationKeyValue.stepperValue: sender.value])
    })
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        self.layoutCountTitle()
        self.layoutCounter()
        self.layoutStepper()
        self.publish()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        self.layoutCountTitle()
        self.layoutCounter()
        self.layoutStepper()
        self.publish()
    }
}

private extension OrderCountSectionView {
    func publish() {
        NotificationCenter.default.addObserver(forName: .counterValueChanged,
                                               object: nil,
                                               queue: .main,
                                               using: changeCountValue(noti:))
    }
    
    func changeCountValue(noti: Notification) {
        guard let count = noti.userInfo?[NotificationKeyValue.count] as? Int else { return }
        self.counter.text = "\(count)"
    }
    
    func layoutCountTitle() {
        self.addSubview(countTitle)
        
        NSLayoutConstraint.activate([
            self.countTitle.leadingAnchor.constraint(equalTo: self.leadingAnchor),
            self.countTitle.topAnchor.constraint(equalTo: self.topAnchor),
            self.countTitle.bottomAnchor.constraint(equalTo: self.bottomAnchor)
        ])
    }
    
    func layoutCounter() {
        self.addSubview(counter)
        
        NSLayoutConstraint.activate([
            self.counter.leadingAnchor.constraint(greaterThanOrEqualTo: self.countTitle.trailingAnchor, constant: 10),
            self.counter.topAnchor.constraint(equalTo: self.topAnchor),
            self.counter.bottomAnchor.constraint(equalTo: self.bottomAnchor)
        ])
    }
    
    func layoutStepper() {
        self.addSubview(stepper)
        
        self.stepper.addAction(stepperTouched, for: .touchUpInside)
        
        NSLayoutConstraint.activate([
            self.stepper.heightAnchor.constraint(equalToConstant: 28),
            self.stepper.leadingAnchor.constraint(equalTo: self.counter.trailingAnchor, constant: CGFloat.defaultInset*3),
            self.stepper.topAnchor.constraint(equalTo: self.topAnchor),
            self.stepper.bottomAnchor.constraint(equalTo: self.bottomAnchor),
            self.stepper.trailingAnchor.constraint(equalTo: self.trailingAnchor),
            self.stepper.widthAnchor.constraint(equalToConstant: 100)
        ])
    }
    
}
