public class MaterialTrim {

    public static String TrimZeros(String suppliedSAPMaterial) {

        int i = 0;
        while (i < suppliedSAPMaterial.length()) {
            if (suppliedSAPMaterial.charAt(i) != '0') {
                break;
            }
            i++;
        }
        String slicedZeros = suppliedSAPMaterial.substring(i);
        return slicedZeros;
    }

    public static void main(String[] args) {
        String sapMaterialOne = "000000000002309892";
        String sapMaterialTwo = "000000000100984160";
        String sapMaterialThree = "000000000099438584";

        System.out.println(TrimZeros(sapMaterialOne));

    }
}