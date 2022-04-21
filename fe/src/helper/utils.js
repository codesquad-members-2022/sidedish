import { css } from 'styled-components';

function flex({ justify, align, direction }) {
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
      ${flex(props)}
    `
  );
}
