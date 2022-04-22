import UIKit

class DetailViewController: UIViewController {

    private let detailView = DetailView()

    override func viewDidLoad() {
        super.viewDidLoad()

        navigationController?.navigationBar.topItem?.title = "뒤로"
        navigationController?.navigationBar.titleTextAttributes =
        [NSAttributedString.Key.font: UIFont(name: Font.sfSemiBold, size: 17) ?? UIFont.systemFont(ofSize: 17)]
        navigationItem.title = "오리 주물럭_반조리"

        detailView.setLayout()
        view = detailView
    }
}
