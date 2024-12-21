import java.util.Scanner;

public class subnetting {
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      System.out.print("Enter IP address: ");
      String ipAddress = scanner.nextLine();
      System.out.print("Enter CIDR notation: ");
      int cidr = scanner.nextInt();

      int totalBits = 32;
      int networkBits = cidr;
      int hostBits = totalBits - networkBits;
      int hostsPerSubnet = (int) Math.pow(2, hostBits) - 2;
      System.out.println("Hosts per subnet: " + hostsPerSubnet);

      String subnetMask = calculateSubnetMask(cidr);
      System.out.println("Subnet Mask: " + subnetMask);

      String firstHost = calculateFirstHost(ipAddress, cidr);
      System.out.println("First host: " + firstHost);

      String lastHost = calculateLastHost(ipAddress, cidr);
      System.out.println("Last host: " + lastHost);

      scanner.close();
   }

   private static String calculateSubnetMask(int cidr) {
      int mask = 0xFFFFFFFF << (32 - cidr);
      return String.format("%d.%d.%d.%d", (mask >> 24) & 0xFF, (mask >> 16) & 0xFF, (mask >> 8) & 0xFF, mask & 0xFF);
   }

   private static String calculateFirstHost(String ipAddress, int cidr) {
      String[] octets = ipAddress.split("\\.");
      int[] ip = new int[4];
      for (int i = 0; i < 4; i++) {
         ip[i] = Integer.parseInt(octets[i]);
      }
      int maskBits = 32 - cidr;
      int hostAddress = (ip[3] & (0xFF << maskBits)) + 1;

      return String.format("%d.%d.%d.%d", ip[0], ip[1], ip[2], hostAddress);
   }

   private static String calculateLastHost(String ipAddress, int cidr) {
      String[] octets = ipAddress.split("\\.");
      int[] ip = new int[4];
      for (int i = 0; i < 4; i++) {
         ip[i] = Integer.parseInt(octets[i]);
      }
      int maskBits = 32 - cidr;
      int hostAddress = (ip[3] & (0xFF << maskBits)) + ((1 << maskBits) - 2);

      return String.format("%d.%d.%d.%d", ip[0], ip[1], ip[2], hostAddress);
   }
}