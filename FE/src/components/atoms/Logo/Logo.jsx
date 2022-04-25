import logo from "@/assets/image/logo.svg";
import { Figure } from "@/components/atoms/Figure/Figure.jsx";
import "./Logo.scss";

export function Logo() {
  return <Figure className="logo" src={logo} alt="logo" />;
}
