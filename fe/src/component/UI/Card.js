import styled, { css } from "styled-components";

const CardImg = styled.img`
  width: 411px;
  height: 411px;
`;

const CardTitle = styled.h4`
  font-size: 18px;
  margin-top: 5px;
`;

const CardDesc = styled.p`
  font-size: 16px;
  margin: 5px 0;
  color: #777;
`;

const CardOriginalPrice = styled.span`
  text-decoration: line-through;
  color: #777;
  font-size: 14px;
  margin-left: 10px;
`;

const CardBadgeWapper = styled.div`
  display: flex;
`;

const CardBadge = styled.div`
  height: 30px;
  line-height: 30px;
  border-radius: 20px;
  color: #fff;
  text-align: center;
  margin-top: 10px;
  margin-right: 10px;
  padding: 0 10px;

  ${(props) =>
    props.children === "런칭특가"
      ? css`
          background: #ff8e14;
        `
      : css`
          background: #6dd028;
        `}
`;

const Card = (props) => {
  return (
    <div>
      <CardImg src={props.image} alt={props.alt} />
      <CardTitle>{props.title}</CardTitle>
      <CardDesc>{props.description}</CardDesc>
      <span>{props.s_price}</span>
      <CardOriginalPrice>{props.n_price}</CardOriginalPrice>
      <CardBadgeWapper>
        {!props.badge
          ? ""
          : props.badge.map((v) => <CardBadge info={v}>{v}</CardBadge>)}
      </CardBadgeWapper>
    </div>
  );
};

// const Card = () => {
//   return (
//     <div>
//       <div>
//         <img src="https://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg"></img>
//       </div>
//       <div>
//         <h4>오리 주물럭_반조리</h4>
//         <p>감칠맛 나는 매콥한 양념</p>
//         <span>12,640원</span>
//         <span className="original-price">15,800원</span>
//         <div className="card-badge">런칭특가</div>
//       </div>
//     </div>
//   );
// };

export default Card;
