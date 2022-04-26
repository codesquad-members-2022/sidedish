import UIKit

class DetailViewBorder: UIView {
    
    private var border: UIView = {
        let view = UIView()
        view.translatesAutoresizingMaskIntoConstraints = false
        view.backgroundColor = .dishGrey3
        return view
    }()

    override init(frame: CGRect) {
        super.init(frame: frame)
        self.layoutBorder()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        self.layoutBorder()
    }
    
}

private extension DetailViewBorder {
    func layoutBorder() {
        self.addSubview(self.border)
        
        NSLayoutConstraint.activate([
            self.border.topAnchor.constraint(equalTo: self.topAnchor, constant: CGFloat.defaultInset*3),
            self.border.leadingAnchor.constraint(equalTo: self.leadingAnchor),
            self.border.trailingAnchor.constraint(equalTo: self.trailingAnchor),
            self.border.bottomAnchor.constraint(equalTo: self.bottomAnchor, constant: -CGFloat.defaultInset*3),
            self.border.heightAnchor.constraint(equalToConstant: 1)
        ])
    }
}
