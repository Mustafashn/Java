import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Tree {
    private TreeNodeMP root;
    private static int eleman_say=0;
    public Tree() {
        this.root=null;
    }
    public TreeNodeMP getRoot() {

        return  this.root;

    }
    public void insert(MilliPark mp) {
        eleman_say+=1;
        TreeNodeMP node = new TreeNodeMP(mp);
        if(this.root==null) {
            this.root=node;

        }
        else {
             TreeNodeMP current=this.root;
             TreeNodeMP parent;
             while(current!= null) {
                 parent=current;
                 //Sol çocuk sağ çocuktan isim olarak alfabede önde gelir
                 if (node.getMp().compareTo(current.getMp()) < 0){
                        current=current.getLeftChildMP();
                        if(current==null) {
                            parent.setLeftChildMP(node);
                            return;
                        }
                    }
                 //sol çocuk sağ çocuktan isim olarak alfabede sonra gelir
                 else {
                        current=current.getRightChildMP();
                        if (current==null) {
                            parent.setRightChildMP(node);
                            return;
                        }
                 }
             }
        }
    }
    public void insertKelime(TreeNodeMP nodeString) {
        if (this.root == null) {
            this.root = nodeString;
        } else {
            TreeNodeMP current = this.root;
            TreeNodeMP parent;
            while (current != null) {
                parent = current;
                //Sol çocuk sağ çocuktan isim olarak alfabede önde gelir
                if (nodeString.getKelime().getIcerik().compareTo(current.getKelime().getIcerik()) < 0) {
                    current = current.getLeftChildMP();
                    if (current == null) {
                        parent.setLeftChildMP(nodeString);
                        return;
                    }
                }
                //sol çocuk sağ çocuktan isim olarak alfabede sonra gelir
                else if (nodeString.getKelime().getIcerik().compareTo(current.getKelime().getIcerik()) == 0) {
                    current.getKelime().setSayac(current.getKelime().getSayac() + 1);
                    return;
                } else {
                    current = current.getRightChildMP();
                    if (current == null) {
                        parent.setRightChildMP(nodeString);
                        return;
                    }
                }
            }
        }
    }
    public void  bul() {
        int height = -1;
        //Ağaç boş ise direkt returnler

        if (this.root == null) {
            return;
        } else {
            //Derinlik hesaplaması için kuyruk oluşturuldu
            Queue<TreeNodeMP> q = new LinkedList<>();
            q.add(this.root);
            while(true) {
                int nodeSayısı=q.size();
                if(nodeSayısı==0) {
                    break;
                }
                height+=1;

                while(nodeSayısı>0) {
                    //Kuyruk başı çıkartılarak atandı ve sağ sol çocukları kontrol edildi kuyruğa eklendi
                    TreeNodeMP nodeMP=q.remove();
                    if(nodeMP.getLeftChildMP()!=null) {
                        q.add(nodeMP.getLeftChildMP());
                    }
                    if(nodeMP.getRightChildMP()!=null) {
                        q.add(nodeMP.getRightChildMP());
                    }
                    nodeSayısı-=1;
                }
            }
        }
        //Ağaç dönülüyor
        preOrder(this.root);
        //Düğüm sayısı ağaçtaki eleman sayısıdır
        //Ağaç her insert ettiğinde Tree sınıfının eleman sayısı arttığından direkt olarak eleman sayısı sayılıyor
        System.out.println("Ağacın derinliği: "+height);
        System.out.println("Ağacın düğüm sayısı: "+eleman_say);
        //Dengeli ağaç derinlik sayısı eleman sayısından yola çıkılarak hesaplanabilir
        double dengeli_derinlik=Math.log(eleman_say)/Math.log(2);
        System.out.printf("Dengeli olsaydı derinlik düzeyi: %.0f \n",Math.floor(dengeli_derinlik));
        //Derinlik yazdırılıyor

    }

    public void preOrder(TreeNodeMP node) {
        if (node !=null) {
            System.out.println(node.getMp().toString());
            preOrder(node.getLeftChildMP());
            preOrder(node.getRightChildMP());
        }
    }
    public void inOrderKelime(TreeNodeMP node) {
        if (node !=null) {
            inOrderKelime(node.getLeftChildMP());
            System.out.println(node.getKelime().getIcerik()+" // Sayaç :"+node.getKelime().getSayac());
            inOrderKelime(node.getRightChildMP());
        }
    }
    public void kelimeAgacıOlustur(TreeNodeMP node,Tree kelimeTree) {
        if (node !=null) {
            String [] kelimeler=node.getMp().getInformationString().split("[. ,;()]");
            for (String s: kelimeler
                 ) {
                Kelime kelime = new Kelime(s);
                TreeNodeMP treeNodeKelime = new TreeNodeMP(kelime);
                kelimeTree.insertKelime(treeNodeKelime);
            }
            kelimeAgacıOlustur(node.getLeftChildMP(),kelimeTree);
            kelimeAgacıOlustur(node.getRightChildMP(),kelimeTree);
        }
    }
    public void parkAra(String arananHarfler,TreeNodeMP node) {
        if(node !=null) {
            if(node.getMp().getName().startsWith(arananHarfler)) {
                System.out.println("Aranan milli parkın bulunduğu il: "+node.getMp().getCity());
            }
            parkAra(arananHarfler,node.getRightChildMP());
            parkAra(arananHarfler,node.getLeftChildMP());
        }
    }

}
