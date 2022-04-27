import { ReactComponent as plusIcon } from "../../asset/plusIcon.svg";
import { ReactComponent as minusIcon } from "../../asset/minusIcon.svg";

import svgStyles from "../../style/svgStyles";
import styled from "styled-components";

const PlusIcon = styled(plusIcon)`
  ${(props) => svgStyles(props)};
`;

const MinusIcon = styled(minusIcon)`
  ${(props) => svgStyles(props)};
`;

export { PlusIcon, MinusIcon };
