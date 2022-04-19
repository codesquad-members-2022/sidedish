export const GnbList = ({cats, title, show}) => {
    return <li>
        <span>{title}</span>
        {show && cats.map(cat => <span>${cat}</span>)}
    </li>
}