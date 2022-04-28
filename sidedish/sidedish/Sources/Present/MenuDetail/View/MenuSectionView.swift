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
        
        contentStackView.snp.makeConstraints { make in
            make.top.left.right.equalToSuperview()
        }
        self.snp.makeConstraints { make in
            make.height.equalTo(contentStackView)
        }
    }
    func makeImageView(count: Int) {
        let imageViews = (0..<count).map { _ -> UIImageView in
            let imageView = UIImageView()
            imageView.contentMode = .scaleToFill
            contentStackView.addArrangedSubview(imageView)
            contentStackView.snp.makeConstraints { make in
                make.width.equalToSuperview()
            }
            return imageView
        }
        contentStackView.snp.makeConstraints { make in
            make.trailing.equalTo(imageViews[imageViews.count - 1])
        }
    }
    
    func setImage(_ index: Int, _ fileUrl: URL) {
        guard let imageView = contentStackView.subviews[index] as? UIImageView,
              let image = UIImage(contentsOfFile: fileUrl.path) else {
            return
        }
        let aspect = frame.width / image.size.width
        imageView.image = image
        imageView.snp.makeConstraints { make in
            make.height.equalTo(image.size.height * aspect)
        }
    }
}
