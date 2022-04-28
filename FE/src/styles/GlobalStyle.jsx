import reset from "styled-reset";
import { createGlobalStyle } from "styled-components";
import fonts from "fonts";

const GlobalStyle = createGlobalStyle`
${reset}
${fonts}
// global 추가할 것
body {
		font-family: "Noto Sans KR";
		font-size: ${({ theme }) => theme.fontSize.medium};
		color: ${({ theme }) => theme.color.black};
}
button{
	cursor:pointer;
}
`;

export default GlobalStyle;
