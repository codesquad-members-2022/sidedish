//
//  MenuSectionView.swift
//  sidedish
//
//  Created by seongha shin on 2022/04/26.
//

import UIKit

class MenuSectionView: UIView {
    
    private let contentStackView: UIStackView = {
        let stackView = UIStackView()
        stackView.translatesAutoresizingMaskIntoConstraints = false
        stackView.axis = .vertical
        return stackView
    }()
    
    init() {
        super.init(frame: .zero)
        layout()
    }
    
    @available(*, unavailable)
    required init?(coder: NSCoder) {
        fatalError("Init with coder is unavailable")
    }
    
    private func layout() {
        addSubview(contentStackView)
        
        NSLayoutConstraint.activate([
            contentStackView.topAnchor.constraint(equalTo: topAnchor),
            contentStackView.leftAnchor.constraint(equalTo: leftAnchor),
            contentStackView.rightAnchor.constraint(equalTo: rightAnchor),
            
            heightAnchor.constraint(equalTo: contentStackView.heightAnchor)
        ])
    }
    func makeImageView(count: Int) {
        let imageViews = (0..<count).map { _ -> UIImageView in
            let imageView = UIImageView()
            imageView.translatesAutoresizingMaskIntoConstraints = false
            imageView.contentMode = .scaleToFill
            contentStackView.addArrangedSubview(imageView)
            imageView.widthAnchor.constraint(equalTo: widthAnchor).isActive = true
            return imageView
        }
        contentStackView.trailingAnchor.constraint(equalTo: imageViews[imageViews.count - 1].trailingAnchor).isActive = true
    }
    
    func setImage(_ index: Int, _ fileUrl: URL) {
        guard let imageView = contentStackView.subviews[index] as? UIImageView,
              let image = UIImage(contentsOfFile: fileUrl.path) else {
            return
        }
        let aspect = frame.width / image.size.width
        imageView.image = image
        imageView.heightAnchor.constraint(equalToConstant: image.size.height * aspect).isActive = true
    }
}
