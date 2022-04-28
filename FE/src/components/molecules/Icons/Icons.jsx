import cart from "@/assets/image/cart.svg";
import myPage from "@/assets/image/myPage.svg";
import search from "@/assets/image/search.svg";
import { Figure } from "@/components/atoms/Figure/Figure.jsx";

export function Icons({ className }) {
  return (
    <div className={className}>
      <Figure src={search} alt="search" />
      <Figure src={myPage} alt="myPage" />
      <Figure src={cart} alt="cart" />
    </div>
  );
}
