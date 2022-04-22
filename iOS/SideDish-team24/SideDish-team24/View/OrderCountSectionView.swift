import UIKit

class OrderCountSectionView: UIView {

    private var countTitle: UILabel = {
        let label = UILabel.customLabel("수량", UIColor.dishLightGrey)
        label.translatesAutoresizingMaskIntoConstraints = false
        return label
    }()
    
    private var counter: UILabel = {
        let label = UILabel.customLabel("1", UIColor.dishGrey)
        label.translatesAutoresizingMaskIntoConstraints = false
        return label
    }()
    
    private var buttons: UIStackView = {
       let stackView = UIStackView()
        stackView.translatesAutoresizingMaskIntoConstraints = false
        stackView.axis = .horizontal
        stackView.distribution = .fill
        stackView.alignment = .center
        stackView.layer.cornerRadius = 5
        stackView.clipsToBounds = true
        return stackView
    }()
    
    private var minusButton: UIButton = {
        let button = UIButton()
        button.translatesAutoresizingMaskIntoConstraints = false
        button.setTitle("-", for: .normal)
        button.titleLabel?.font = UIFont.systemFont(ofSize: 17)
        button.setTitleColor(UIColor.black, for: .normal)
        button.backgroundColor = UIColor.dishGrey4
        return button
    }()
    
    private var separator: UIView = {
        let view = UIView()
        view.translatesAutoresizingMaskIntoConstraints = false
        view.backgroundColor = UIColor.dishGrey3
        return view
    }()
    
    private var plusButton: UIButton = {
        let button = UIButton()
        button.translatesAutoresizingMaskIntoConstraints = false
        button.setTitle("+", for: .normal)
        button.titleLabel?.font = UIFont.systemFont(ofSize: 17)
        button.setTitleColor(UIColor.black, for: .normal)
        button.backgroundColor = UIColor.dishGrey4
        return button
    }()
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        self.layoutCountTitle()
        self.layoutCounter()
        self.layoutButtons()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        self.layoutCountTitle()
        self.layoutCounter()
        self.layoutButtons()
    }
    
    private func layoutCountTitle() {
        self.addSubview(countTitle)
        
        NSLayoutConstraint.activate([
            self.countTitle.leadingAnchor.constraint(equalTo: self.leadingAnchor),
            self.countTitle.topAnchor.constraint(equalTo: self.topAnchor),
            self.countTitle.bottomAnchor.constraint(equalTo: self.bottomAnchor),
        ])
    }
    
    private func layoutCounter() {
        self.addSubview(counter)
        
        NSLayoutConstraint.activate([
            self.counter.leadingAnchor.constraint(greaterThanOrEqualTo: self.countTitle.trailingAnchor, constant:  10),
            self.counter.topAnchor.constraint(equalTo: self.topAnchor),
            self.counter.bottomAnchor.constraint(equalTo: self.bottomAnchor),
        ])
    }
    
    private func layoutButtons() {
        self.addSubview(buttons)
        self.buttons.addArrangedSubview(minusButton)
        self.buttons.addArrangedSubview(separator)
        self.buttons.addArrangedSubview(plusButton)
        
        NSLayoutConstraint.activate([
            self.buttons.heightAnchor.constraint(equalToConstant: 28),
            self.buttons.leadingAnchor.constraint(equalTo: self.counter.trailingAnchor, constant: CGFloat.defaultInset*3),
            self.buttons.topAnchor.constraint(equalTo: self.topAnchor),
            self.buttons.bottomAnchor.constraint(equalTo: self.bottomAnchor),
            self.buttons.trailingAnchor.constraint(equalTo: self.trailingAnchor),
            self.buttons.widthAnchor.constraint(equalToConstant: 100),
            
            self.minusButton.widthAnchor.constraint(equalTo: self.plusButton.widthAnchor),
            self.separator.widthAnchor.constraint(equalToConstant: 1),
            self.separator.heightAnchor.constraint(equalTo: self.buttons.heightAnchor, multiplier: 0.6)
        ])
    }
}
