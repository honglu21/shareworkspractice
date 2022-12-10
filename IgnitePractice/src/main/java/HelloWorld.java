import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.IgniteException;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.internal.marshaller.optimized.OptimizedMarshaller;
import org.apache.ignite.internal.marshaller.optimized.OptimizedMarshallerIdMapper;
import org.apache.ignite.lang.IgniteRunnable;
import org.apache.ignite.marshaller.jdk.JdkMarshaller;
import org.apache.ignite.resources.IgniteInstanceResource;

import javax.xml.bind.Marshaller;

public class HelloWorld {
    public static void main(String[] args) throws IgniteException {
        // Preparing IgniteConfiguration using Java APIs
        IgniteConfiguration cfg = new IgniteConfiguration();
        cfg.setClientMode(true);
        cfg.setPeerClassLoadingEnabled(true);
//        TcpDiscoveryMulticastIpFinder ipFinder = new TcpDiscoveryMulticastIpFinder();
//        ipFinder.setAddresses(Collections.singletonList("127.0.0.1:47500..47509"));
//        cfg.setDiscoverySpi(new TcpDiscoverySpi().setIpFinder(ipFinder));
        //JdkMarshaller marshaller = new JdkMarshaller();
        //cfg.setMarshaller(marshaller);
        Ignite ignite = Ignition.start(cfg);
        OptimizedMarshaller optimizedMarshaller = new OptimizedMarshaller();
        optimizedMarshaller = (OptimizedMarshaller) ignite.configuration().getMarshaller();
        //marshaller = (JdkMarshaller) ignite.configuration().getMarshaller();


        IgniteCache<Integer, String> cache = ignite.getOrCreateCache("myCache");
        cache.put(1, "Hello");
        cache.put(2, "World!");

        PlaySports myPlaySports = new PlaySports();
        myPlaySports.sport = Sports.FOOTBALL.name();
        myPlaySports.addMySports(Sports.FOOTBALL);
        myPlaySports.addMySports(Sports.BASKETBALL);
        myPlaySports.setName("Test");

        IgniteCache<Integer, String> sportsCache = ignite.getOrCreateCache("sportsCache");
        sportsCache.put(1, myPlaySports.sport);
        sportsCache.put(2, myPlaySports.getMySport(0).name());
        sportsCache.put(3, myPlaySports.getMySport(1).name());

        System.out.println(">> myPlaySports " + myPlaySports.getMySport(0) + ' ' + myPlaySports.getMySport(1));

        IgniteCache<Integer, String> enumCache = ignite.getOrCreateCache("enumCache");
        enumCache.put(1, Sports.BASKETBALL.name());
        enumCache.put(2, Sports.FOOTBALL.name());

        System.out.println(">> Create the cache and add the values.");
        ignite.compute(ignite.cluster().forServers()).broadcast(new RemoteTask());

        System.out.println(">> Compute task is executed, check for output on the server nodes.");

        ignite.close();

    }

    private static class RemoteTask implements IgniteRunnable {
        @IgniteInstanceResource
        Ignite ignite;
        @Override
        public void run() {
            System.out.println(">> Executing the compute task");

            System.out.println("   Node ID: " + ignite.cluster().localNode().id() + "\n" +
                    "   OS: " + System.getProperty("os.name") +
                    "   JRE: " + System.getProperty("java.runtime.name"));

            IgniteCache<Integer, String> cache = ignite.cache("myCache");
            IgniteCache<Integer, String> sportsCache = ignite.cache("sportsCache");
            IgniteCache<Integer, String> enumCache = ignite.cache("enumCache");

            System.out.println(">> " + cache.get(1) + " " + cache.get(2));
            System.out.println(">> " + sportsCache.get(1) + " " + sportsCache.get(2));
            System.out.println(">> " + enumCache.get(1) + " " + enumCache.get(2));

        }

    }
}
