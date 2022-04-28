import logo from "@/assets/image/logo.svg";
import { Figure } from "@/components/atoms/Figure/Figure.jsx";

export function Logo({ className }) {
  return <Figure className={className} src={logo} alt="logo" />;
}
