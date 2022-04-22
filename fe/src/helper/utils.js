import { css } from 'styled-components';

function getFlexString({ justify, align, direction }) {
  justify = justify || 'start';
  align = align || 'stretch';
  direction = direction || 'row';
  return `
    display: flex;
    justify-content: ${justify};
    align-items: ${align};
    flex-direction: ${direction};
  `;
}

export function applyFlex(props) {
  return (
    props.flex &&
    css`
      ${getFlexString(props)}
    `
  );
}
