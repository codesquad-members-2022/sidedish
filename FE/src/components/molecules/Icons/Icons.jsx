<<<<<<< HEAD
=======
import "./Icons.scss";
>>>>>>> 0847aee ([#31] Feat: Header 컴포넌트에 Atomic Design Pattern 적용)
import cart from "@/assets/image/cart.svg";
import myPage from "@/assets/image/myPage.svg";
import search from "@/assets/image/search.svg";
import { Figure } from "@/components/atoms/Figure/Figure.jsx";

<<<<<<< HEAD
export function Icons({ className }) {
  return (
    <div className={className}>
=======
export function Icons() {
  return (
    <div className="icon-container">
>>>>>>> 0847aee ([#31] Feat: Header 컴포넌트에 Atomic Design Pattern 적용)
      <Figure src={search} alt="search" />
      <Figure src={myPage} alt="myPage" />
      <Figure src={cart} alt="cart" />
    </div>
  );
}
