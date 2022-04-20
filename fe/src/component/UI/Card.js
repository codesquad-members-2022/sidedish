import "./Card.css";

const Card = () => {
  return (
    <div>
      <div>
        <img src="https://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg"></img>
      </div>
      <div>
        <h4>오리 주물럭_반조리</h4>
        <p>감칠맛 나는 매콥한 양념</p>
        <span>12,640원</span>
        <span className="original-price">15,800원</span>
        <div className="card-badge">런칭특가</div>
      </div>
    </div>
  );
};

export default Card;
